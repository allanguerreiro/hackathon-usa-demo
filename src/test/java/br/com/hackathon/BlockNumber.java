package br.com.hackathon;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

public class BlockNumber {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/d005aa0e082340aa90f3fb1af7395b30"));
        EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
    }
}