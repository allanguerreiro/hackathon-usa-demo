package br.com.hackathon.service;

import br.com.hackathon.contract.Example;
import br.com.hackathon.contract.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static br.com.hackathon.constant.Constants.*;

@Slf4j
@Service
public class Web3Service {

    private Web3j web3j = Web3j.build(new HttpService("https://quick-bitter-river.discover.quiknode.pro/ef178538a06fb20ed08c9f04b77cc874e52fcf0d/"));

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
            log.info("Etherium Accounts {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public EthGetTransactionCount getTransactionCount() {
        EthGetTransactionCount result = new EthGetTransactionCount();
        try {
            result = this.web3j.ethGetTransactionCount(DEFAULT_ADDRESS, DefaultBlockParameter.valueOf("latest")).sendAsync().get();
            log.info("Transaction Count {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public EthGetBalance getEthBalance() {
        EthGetBalance result = new EthGetBalance();
        try {
            result = this.web3j.ethGetBalance(DEFAULT_ADDRESS, DefaultBlockParameter.valueOf("latest")).sendAsync().get();
            log.info("Ethereium Balance {}", result);
        } catch (Exception ex) {
            log.error(GENERIC_EXCEPTION, ex);
        }
        return result;
    }

    public String getContractAddress() {

        String contractAddress = "";

        try {
            Credentials credentials = getCredentials();
            contractAddress = credentials.getAddress();

            //Deploy contract to address specified by wallet
            CompletableFuture<Greeting> contractGreeting = Greeting.deploy(this.web3j,
                    credentials,
                    ManagedTransaction.GAS_PRICE,
                    Contract.GAS_LIMIT, "").sendAsync();
            log.info("Greeting {}", contractGreeting);

            CompletableFuture<Example> contractExample = Example.deploy(this.web3j,
                    credentials,
                    ManagedTransaction.GAS_PRICE,
                    Contract.GAS_LIMIT).sendAsync();
            log.info("Example {}", contractExample);
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return contractAddress;
        }
        return contractAddress;
    }

    @Async
    public String sendTransaction() {
        String transactionHash = "";

        try {
            List inputParams = new ArrayList();
            List outputParams = new ArrayList();
            Function function = new Function("fuctionName", inputParams, outputParams);

            String encodedFunction = FunctionEncoder.encode(function);

            Credentials credentials = getCredentials();

            BigInteger nonce = BigInteger.valueOf(100);
            BigInteger gasprice = BigInteger.valueOf(100);
            BigInteger gaslimit = BigInteger.valueOf(100);
            log.info("Before Transaction");
            Transaction transaction = Transaction.createFunctionCallTransaction(credentials.getAddress(), nonce, gasprice, gaslimit, getContractAddress(), encodedFunction);
            log.info("After Transaction");
            EthSendTransaction transactionResponse = web3j.ethSendTransaction(transaction).sendAsync().get();
            if (transactionResponse.getResult() == null) {
                log.info("Transaction {}", transactionResponse.getError().getMessage());
                return transactionResponse.getError().getMessage();
            }
            transactionHash = transactionResponse.getTransactionHash();
            log.info("Transaction {}", transactionHash);
        } catch (Exception ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            return PLEASE_SUPPLY_REAL_DATA;
        }

        return transactionHash;
    }

    private Credentials getCredentials() {
        try {
            final var walletPassword = "trumpshouldbeimpeached";
            final var walletDirectory = "C:\\Users\\allan\\OneDrive\\Documentos\\hackathon";
            //Create a wallet
            final var walletName = WalletUtils.generateNewWalletFile(walletPassword, new File(walletDirectory), true);
            log.info("Wallet name: " + walletName);
            //Load the credentials from it
            return WalletUtils.loadCredentials(walletPassword, walletDirectory + "/" + walletName);
        } catch (CipherException | IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException |
                 NoSuchProviderException ex) {
            log.error(PLEASE_SUPPLY_REAL_DATA, ex);
            throw new RuntimeException(ex);
        }
    }
}