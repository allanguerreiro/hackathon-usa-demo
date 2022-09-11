package br.com.hackathon;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Slf4j
public class Web3J {
    public static void main(String[] args) throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {

        Web3j web3 = Web3j.build(new HttpService("https://quick-bitter-river.discover.quiknode.pro/ef178538a06fb20ed08c9f04b77cc874e52fcf0d/"));

        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        log.info("Client version {}", clientVersion);

//        Subscribing for New Blocks
        Subscription subscription = (Subscription) web3.blockFlowable(false)
                .subscribe(block -> log.info("Subscribing for New Blocks {}", block.getBlock().getHash()));

        //Subscribing for New Transactions
        web3.transactionFlowable().subscribe(tx -> {
            log.info("Subscribing for New Transactions {}", tx.getHash());
        });

        //Subscribing to pending Transactions
        web3.pendingTransactionFlowable().subscribe(tx -> {
            log.info("Subscribing to pending Transactions {}", tx.getHash());
        });

        final var walletPassword = "trumpshouldbeimpeached";
        final var walletDirectory = "D:\\Desenvolvimento";

        final var walletName = WalletUtils.generateNewWalletFile(walletPassword, new File(walletDirectory));

        log.info("Wallet name: " + walletName);
        //Loading Wallet
        Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory + "/" + walletName);

        String accountAddress = credentials.getAddress();
        log.info("Account address: " + accountAddress);

        SimpleBank simpleBank = SimpleBank.load(accountAddress, web3, credentials, new DefaultGasProvider());

        simpleBank.logDepositMadeEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .doOnError(error -> log.error("The error message is: {}", error.getMessage()))
                .subscribe(logDepositMadeEventResponse ->
                        log.info("logDepositMadeEventResponse {}", logDepositMadeEventResponse.amount));
    }
}
