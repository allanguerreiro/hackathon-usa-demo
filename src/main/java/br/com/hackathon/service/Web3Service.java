package br.com.hackathon.service;

import br.com.hackathon.contract.Developer;
import br.com.hackathon.contract.ManageDev;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Optional;

import static br.com.hackathon.constant.Constants.GENERIC_EXCEPTION;
import static br.com.hackathon.constant.Constants.PLEASE_SUPPLY_REAL_DATA;

@Slf4j
@Service
public class Web3Service {
    String PRIVATE_KEY = "298393836b1479b9c76362ed8f346848f70ec9d24fdb67f62f9bfc07cf9c599c";
    private Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));

    //Create and Init the default Web3J connection
    public void customInit(String provider) {
        this.web3j = Web3j.build(new HttpService(provider));
    }

    //Convert to and from supplied contract ABI bytecode
    public static String toBinary(String bytecode) {
        return bytecode.replaceFirst("^0x", "");
    }

    public static String toByteCode(String binary) {
        return "0x" + binary;
    }

    public EthBlockNumber getBlockNumber() {
        EthBlockNumber result = new EthBlockNumber();
        try {
            result = this.web3j.ethBlockNumber().sendAsync().get();
            log.info("Block Number {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public EthAccounts getEthAccounts() {
        EthAccounts result = new EthAccounts();
        try {
            result = this.web3j.ethAccounts().sendAsync().get();
            log.info("Ethereum Accounts {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public EthGetTransactionCount getTransactionCount() {
        EthGetTransactionCount result = new EthGetTransactionCount();
        try {
            result = this.web3j.ethGetTransactionCount(getCredentials(PRIVATE_KEY).getAddress(), DefaultBlockParameter.valueOf("latest")).sendAsync().get();
            log.info("Transaction Count {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public EthGetBalance getEthBalance() {
        EthGetBalance result = new EthGetBalance();
        try {
            result = this.web3j.ethGetBalance(getCredentials(PRIVATE_KEY).getAddress(), DefaultBlockParameter.valueOf("latest")).sendAsync().get();
            log.info("Ethereum Balance {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public String getContractAddress() {
        String contractAddress = "";
        try {
            Credentials credentials = getCredentials(PRIVATE_KEY);
            contractAddress = credentials.getAddress();
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return contractAddress;
        }
        return contractAddress;
    }

    public String deployContractDeveloper() {
        Developer developer;
        try {
            //Deploy contract to address specified by wallet
            developer = Developer.deploy(this.web3j,
                    getCredentials(PRIVATE_KEY),
                    ManagedTransaction.GAS_PRICE,
                    Contract.GAS_LIMIT).send();
            log.info("Developer {}", developer);
            return developer.getContractAddress();
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return PLEASE_SUPPLY_REAL_DATA;
        }
    }

    public String deployContractManageDev() {
        ManageDev manageDev;
        try {
            manageDev = ManageDev.deploy(this.web3j,
                    getCredentials(PRIVATE_KEY),
                    ManagedTransaction.GAS_PRICE,
                    Contract.GAS_LIMIT).send();
            log.info("ManageDev {}", manageDev);
            return manageDev.getContractAddress();
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return PLEASE_SUPPLY_REAL_DATA;
        }
    }

    public String sendEthereumTransaction() {
        String transactionHash;

        try {
            Function function = new Function("functionName", Collections.emptyList(), Collections.emptyList());
            Credentials credentials = getCredentials(PRIVATE_KEY);

            // Get the latest nonce of current account
            EthGetTransactionCount ethGetTransactionCount = web3j
                    .ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            log.info("Amount to be sent: 12");
            BigInteger value = Convert.toWei("12", Convert.Unit.ETHER).toBigInteger();

            // Gas Parameter
            final var gasLimit = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf("latest"), true).send().getBlock().getGasLimit();
            final var gasPrice = web3j.ethGasPrice().send().getGasPrice();
            log.info("EthGasPrice {}", gasPrice);

            Transaction transaction = Transaction.createFunctionCallTransaction(credentials.getAddress(), nonce, gasPrice, gasLimit, getContractAddress(), value, FunctionEncoder.encode(function));

            EthSendTransaction transactionResponse = web3j.ethSendTransaction(transaction).sendAsync().get();
            if (transactionResponse.getResult() == null) {
                log.info("Transaction {}", transactionResponse.getError().getMessage());
                return transactionResponse.getError().getMessage();
            }
            transactionHash = transactionResponse.getTransactionHash();
            log.info("Transaction {}", transactionHash);

            // Wait for transaction to be mined
            mined(transactionHash, credentials);
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return PLEASE_SUPPLY_REAL_DATA;
        }

        return transactionHash;
    }

    private Credentials getCredentials(String privateKey) {
        try {
            return Credentials.create(privateKey);
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            throw new RuntimeException(ex);
        }
    }

    public void testTutorial() {
        log.info("Connecting to Ethereum ...");
        Web3j web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
        log.info("Successfuly connected to Ethereum");

        try {
            String privetKey = "298393836b1479b9c76362ed8f346848f70ec9d24fdb67f62f9bfc07cf9c599c"; // Add a private key here
            // Decrypt private key into Credential object
            Credentials credentials = Credentials.create(privetKey);
            log.info("Account address: " + credentials.getAddress());
            log.info("Balance: "
                    + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST)
                    .send().getBalance().toString(), Convert.Unit.ETHER));

            // Get the latest nonce of current account
            EthGetTransactionCount ethGetTransactionCount = web3
                    .ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            // Recipient address
            String recipientAddress = credentials.getAddress();
            // Value to transfer (in wei)
            log.info("Enter Amount to be sent: 10");
            BigInteger value = Convert.toWei("10", Convert.Unit.ETHER).toBigInteger();

            // Gas Parameter
            BigInteger gasLimit = BigInteger.valueOf(21000);
            //eth_gasPrice, returns the current price per gas in wei.
            EthGasPrice gasPrice = web3j.ethGasPrice().send();
            //BigInteger gasPrice = Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();

            // Prepare the rawTransaction
            RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice.getGasPrice(), gasLimit,
                    recipientAddress, value);

            // Sign the transaction
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);

            // Send transaction
            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
            String transactionHash = ethSendTransaction.getTransactionHash();
            log.info("transactionHash: " + transactionHash);

            // Wait for transaction to be mined
            mined(transactionHash, credentials);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void mined(String transactionHash, Credentials credentials) {
        try {
            // Wait for transaction to be mined
            Optional<TransactionReceipt> transactionReceipt;
            do {
                log.info("checking if transaction " + transactionHash + " is mined....");
                EthGetTransactionReceipt ethGetTransactionReceiptResp = web3j.ethGetTransactionReceipt(transactionHash)
                        .send();
                transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
                Thread.sleep(3000); // Wait for 3 sec
            } while (!transactionReceipt.isPresent());

            log.info("Transaction " + transactionHash + " was mined in block # "
                    + transactionReceipt.get().getBlockNumber());
            log.info("Balance: "
                    + Convert.fromWei(web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST)
                    .send().getBalance().toString(), Convert.Unit.ETHER));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}