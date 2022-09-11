package br.com.hackathon.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Developer extends Contract {
    public static final String BINARY = "6080604052600560005534801561001557600080fd5b506101bd806100256000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80634f2be91f146100465780636deebae3146100505780638ada066e1461005a575b600080fd5b61004e610078565b005b610058610091565b005b6100626100aa565b60405161006f91906100cc565b60405180910390f35b60008081548092919061008a90610116565b9190505550565b6000808154809291906100a39061015e565b9190505550565b60008054905090565b6000819050919050565b6100c6816100b3565b82525050565b60006020820190506100e160008301846100bd565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610121826100b3565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203610153576101526100e7565b5b600182019050919050565b6000610169826100b3565b91506000820361017c5761017b6100e7565b5b60018203905091905056fea2646970667358221220371a8a2eb8a290900dbedb980c8b52212fb4ad212a0949ad263e5bdbf0d26eb464736f6c63430008110033";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_GETCOUNTER = "getCounter";

    public static final String FUNC_SUBTRACT = "subtract";

    @Deprecated
    protected Developer(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Developer(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Developer(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Developer(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> add() {
        final Function function = new Function(
                FUNC_ADD, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getCounter() {
        final Function function = new Function(FUNC_GETCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> subtract() {
        final Function function = new Function(
                FUNC_SUBTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Developer load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Developer(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Developer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Developer(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Developer load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Developer(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Developer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Developer(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Developer> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Developer.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Developer> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Developer.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Developer> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Developer.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Developer> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Developer.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
