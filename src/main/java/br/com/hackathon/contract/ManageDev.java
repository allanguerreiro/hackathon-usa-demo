package br.com.hackathon.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
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
public class ManageDev extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061111b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063208410fa1461005c578063547df8531461008c5780636d4ce63c146100a8578063b8344aac146100cb578063b96b099f146100e7575b600080fd5b610076600480360381019061007191906109d8565b61011c565b6040516100839190610a1e565b60405180910390f35b6100a660048036038101906100a19190610c08565b610167565b005b6100b0610379565b6040516100c296959493929190610d9f565b60405180910390f35b6100e560048036038101906100e09190610c08565b610566565b005b61010160048036038101906100fc91906109d8565b610778565b60405161011396959493929190610d9f565b60405180910390f35b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201549050919050565b600073ffffffffffffffffffffffffffffffffffffffff166000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461020157600080fd5b6040518060c001604052803373ffffffffffffffffffffffffffffffffffffffff168152602001858152602001848152602001600115158152602001831515815260200182600481111561025857610257610d28565b5b8152506000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190816102f59190611013565b506040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555060808201518160030160016101000a81548160ff02191690831515021790555060a08201518160030160026101000a81548160ff0219169083600481111561036b5761036a610d28565b5b021790555090505050505050565b6000606060008060008060008060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206040518060c00160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201805461043490610e36565b80601f016020809104026020016040519081016040528092919081815260200182805461046090610e36565b80156104ad5780601f10610482576101008083540402835291602001916104ad565b820191906000526020600020905b81548152906001019060200180831161049057829003601f168201915b50505050508152602001600282015481526020016003820160009054906101000a900460ff161515151581526020016003820160019054906101000a900460ff161515151581526020016003820160029054906101000a900460ff16600481111561051b5761051a610d28565b5b600481111561052d5761052c610d28565b5b815250509050806000015181602001518260400151836060015184608001518560a0015196509650965096509650965050909192939495565b600073ffffffffffffffffffffffffffffffffffffffff166000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff160361060057600080fd5b6040518060c001604052803373ffffffffffffffffffffffffffffffffffffffff168152602001858152602001848152602001600115158152602001831515815260200182600481111561065757610656610d28565b5b8152506000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190816106f49190611013565b506040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555060808201518160030160016101000a81548160ff02191690831515021790555060a08201518160030160026101000a81548160ff0219169083600481111561076a57610769610d28565b5b021790555090505050505050565b6000606060008060008060008060008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206040518060c00160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201805461083390610e36565b80601f016020809104026020016040519081016040528092919081815260200182805461085f90610e36565b80156108ac5780601f10610881576101008083540402835291602001916108ac565b820191906000526020600020905b81548152906001019060200180831161088f57829003601f168201915b50505050508152602001600282015481526020016003820160009054906101000a900460ff161515151581526020016003820160019054906101000a900460ff161515151581526020016003820160029054906101000a900460ff16600481111561091a57610919610d28565b5b600481111561092c5761092b610d28565b5b815250509050806000015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006109a58261097a565b9050919050565b6109b58161099a565b81146109c057600080fd5b50565b6000813590506109d2816109ac565b92915050565b6000602082840312156109ee576109ed610970565b5b60006109fc848285016109c3565b91505092915050565b6000819050919050565b610a1881610a05565b82525050565b6000602082019050610a336000830184610a0f565b92915050565b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610a8c82610a43565b810181811067ffffffffffffffff82111715610aab57610aaa610a54565b5b80604052505050565b6000610abe610966565b9050610aca8282610a83565b919050565b600067ffffffffffffffff821115610aea57610ae9610a54565b5b610af382610a43565b9050602081019050919050565b82818337600083830152505050565b6000610b22610b1d84610acf565b610ab4565b905082815260208101848484011115610b3e57610b3d610a3e565b5b610b49848285610b00565b509392505050565b600082601f830112610b6657610b65610a39565b5b8135610b76848260208601610b0f565b91505092915050565b610b8881610a05565b8114610b9357600080fd5b50565b600081359050610ba581610b7f565b92915050565b60008115159050919050565b610bc081610bab565b8114610bcb57600080fd5b50565b600081359050610bdd81610bb7565b92915050565b60058110610bf057600080fd5b50565b600081359050610c0281610be3565b92915050565b60008060008060808587031215610c2257610c21610970565b5b600085013567ffffffffffffffff811115610c4057610c3f610975565b5b610c4c87828801610b51565b9450506020610c5d87828801610b96565b9350506040610c6e87828801610bce565b9250506060610c7f87828801610bf3565b91505092959194509250565b610c948161099a565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610cd4578082015181840152602081019050610cb9565b60008484015250505050565b6000610ceb82610c9a565b610cf58185610ca5565b9350610d05818560208601610cb6565b610d0e81610a43565b840191505092915050565b610d2281610bab565b82525050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b60058110610d6857610d67610d28565b5b50565b6000819050610d7982610d57565b919050565b6000610d8982610d6b565b9050919050565b610d9981610d7e565b82525050565b600060c082019050610db46000830189610c8b565b8181036020830152610dc68188610ce0565b9050610dd56040830187610a0f565b610de26060830186610d19565b610def6080830185610d19565b610dfc60a0830184610d90565b979650505050505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610e4e57607f821691505b602082108103610e6157610e60610e07565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302610ec97fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610e8c565b610ed38683610e8c565b95508019841693508086168417925050509392505050565b6000819050919050565b6000610f10610f0b610f0684610a05565b610eeb565b610a05565b9050919050565b6000819050919050565b610f2a83610ef5565b610f3e610f3682610f17565b848454610e99565b825550505050565b600090565b610f53610f46565b610f5e818484610f21565b505050565b5b81811015610f8257610f77600082610f4b565b600181019050610f64565b5050565b601f821115610fc757610f9881610e67565b610fa184610e7c565b81016020851015610fb0578190505b610fc4610fbc85610e7c565b830182610f63565b50505b505050565b600082821c905092915050565b6000610fea60001984600802610fcc565b1980831691505092915050565b60006110038383610fd9565b9150826002028217905092915050565b61101c82610c9a565b67ffffffffffffffff81111561103557611034610a54565b5b61103f8254610e36565b61104a828285610f86565b600060209050601f83116001811461107d576000841561106b578287015190505b6110758582610ff7565b8655506110dd565b601f19841661108b86610e67565b60005b828110156110b35784890151825560018201915060208501945060208101905061108e565b868310156110d057848901516110cc601f891682610fd9565b8355505b6001600288020188555050505b50505050505056fea26469706673582212209766d12d7047ea890f4309a2fc550cc7034c660cd3581c178e24874ef54cc75164736f6c63430008110033";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_GET = "get";

    public static final String FUNC_GET_BY_ADDRESS = "get_by_address";

    public static final String FUNC_GET_DEV_VALUE_BY_ADDRESS = "get_dev_value_by_address";

    public static final String FUNC_UPDATE = "update";

    @Deprecated
    protected ManageDev(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ManageDev(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ManageDev(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ManageDev(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> create(String _name, BigInteger _value_day, Boolean _is_working, BigInteger _skill) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_value_day), 
                new org.web3j.abi.datatypes.Bool(_is_working), 
                new org.web3j.abi.datatypes.generated.Uint8(_skill)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>> get() {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>>(function,
                new Callable<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>> get_by_address(String user) {
        final Function function = new Function(FUNC_GET_BY_ADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>>(function,
                new Callable<Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>>() {
                    @Override
                    public Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, BigInteger, Boolean, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> get_dev_value_by_address(String user) {
        final Function function = new Function(FUNC_GET_DEV_VALUE_BY_ADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> update(String _name, BigInteger _value_day, Boolean _is_working, BigInteger _skill) {
        final Function function = new Function(
                FUNC_UPDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_value_day), 
                new org.web3j.abi.datatypes.Bool(_is_working), 
                new org.web3j.abi.datatypes.generated.Uint8(_skill)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ManageDev load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManageDev(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ManageDev load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManageDev(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ManageDev load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ManageDev(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ManageDev load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ManageDev(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ManageDev> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ManageDev.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ManageDev> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManageDev.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ManageDev> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ManageDev.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ManageDev> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManageDev.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
