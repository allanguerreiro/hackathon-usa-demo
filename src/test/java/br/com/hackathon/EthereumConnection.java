package br.com.hackathon;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import java.io.IOException;

public class EthereumConnection {

    public static void main(String[] args) throws Exception {

        System.out.println("Connecting to Ethereum …");
        Web3j web3 = Web3j.build(new HttpService("https://quick-bitter-river.discover.quiknode.pro/ef178538a06fb20ed08c9f04b77cc874e52fcf0d/"));
        System.out.println("Successfuly connected to Ethereum");

        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().send();
            System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());

            EthGasPrice gasPrice = web3.ethGasPrice().send();
            System.out.println("Default Gas Price: " + gasPrice.getGasPrice());

            EthGetBalance ethGetBalance = web3
                    .ethGetBalance("0xcF8B652b0173FBABE734f5F388C2da24a2359993", DefaultBlockParameterName.LATEST)
                    .sendAsync().get();

            System.out.println("Balance:of Account ‘0xcF8B652b0173FBABE734f5F388C2da24a2359993’ "
                    + ethGetBalance.getBalance());

            System.out.println("Balance in Ether format: "
                    + Convert.fromWei(web3.ethGetBalance("0xcF8B652b0173FBABE734f5F388C2da24a2359993",
                    DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));

        } catch (IOException ex) {
            throw new RuntimeException("Error whilst sending json - rpc requests", ex);
        }
    }
}
