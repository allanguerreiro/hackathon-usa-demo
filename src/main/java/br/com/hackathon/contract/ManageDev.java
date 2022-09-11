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
    public static final String BINARY = "608060405234801561001057600080fd5b5061107a806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c8063547df853146100515780636d4ce63c1461006d578063b8344aac14610090578063b96b099f146100ac575b600080fd5b61006b60048036038101906100669190610acd565b6100e1565b005b6100756102f3565b60405161008796959493929190610ca5565b60405180910390f35b6100aa60048036038101906100a59190610acd565b6104e0565b005b6100c660048036038101906100c19190610d39565b6106f2565b6040516100d896959493929190610ca5565b60405180910390f35b600073ffffffffffffffffffffffffffffffffffffffff166000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461017b57600080fd5b6040518060c001604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200184815260200160011515815260200183151581526020018260048111156101d2576101d1610c2e565b5b8152506000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908161026f9190610f72565b506040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555060808201518160030160016101000a81548160ff02191690831515021790555060a08201518160030160026101000a81548160ff021916908360048111156102e5576102e4610c2e565b5b021790555090505050505050565b6000606060008060008060008060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206040518060c00160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820180546103ae90610d95565b80601f01602080910402602001604051908101604052809291908181526020018280546103da90610d95565b80156104275780601f106103fc57610100808354040283529160200191610427565b820191906000526020600020905b81548152906001019060200180831161040a57829003601f168201915b50505050508152602001600282015481526020016003820160009054906101000a900460ff161515151581526020016003820160019054906101000a900460ff161515151581526020016003820160029054906101000a900460ff16600481111561049557610494610c2e565b5b60048111156104a7576104a6610c2e565b5b815250509050806000015181602001518260400151836060015184608001518560a0015196509650965096509650965050909192939495565b600073ffffffffffffffffffffffffffffffffffffffff166000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff160361057a57600080fd5b6040518060c001604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200184815260200160011515815260200183151581526020018260048111156105d1576105d0610c2e565b5b8152506000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908161066e9190610f72565b506040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555060808201518160030160016101000a81548160ff02191690831515021790555060a08201518160030160026101000a81548160ff021916908360048111156106e4576106e3610c2e565b5b021790555090505050505050565b6000606060008060008060008060008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206040518060c00160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820180546107ad90610d95565b80601f01602080910402602001604051908101604052809291908181526020018280546107d990610d95565b80156108265780601f106107fb57610100808354040283529160200191610826565b820191906000526020600020905b81548152906001019060200180831161080957829003601f168201915b50505050508152602001600282015481526020016003820160009054906101000a900460ff161515151581526020016003820160019054906101000a900460ff161515151581526020016003820160029054906101000a900460ff16600481111561089457610893610c2e565b5b60048111156108a6576108a5610c2e565b5b815250509050806000015181602001518260400151836060015184608001518560a001519650965096509650965096505091939550919395565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610947826108fe565b810181811067ffffffffffffffff821117156109665761096561090f565b5b80604052505050565b60006109796108e0565b9050610985828261093e565b919050565b600067ffffffffffffffff8211156109a5576109a461090f565b5b6109ae826108fe565b9050602081019050919050565b82818337600083830152505050565b60006109dd6109d88461098a565b61096f565b9050828152602081018484840111156109f9576109f86108f9565b5b610a048482856109bb565b509392505050565b600082601f830112610a2157610a206108f4565b5b8135610a318482602086016109ca565b91505092915050565b6000819050919050565b610a4d81610a3a565b8114610a5857600080fd5b50565b600081359050610a6a81610a44565b92915050565b60008115159050919050565b610a8581610a70565b8114610a9057600080fd5b50565b600081359050610aa281610a7c565b92915050565b60058110610ab557600080fd5b50565b600081359050610ac781610aa8565b92915050565b60008060008060808587031215610ae757610ae66108ea565b5b600085013567ffffffffffffffff811115610b0557610b046108ef565b5b610b1187828801610a0c565b9450506020610b2287828801610a5b565b9350506040610b3387828801610a93565b9250506060610b4487828801610ab8565b91505092959194509250565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610b7b82610b50565b9050919050565b610b8b81610b70565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610bcb578082015181840152602081019050610bb0565b60008484015250505050565b6000610be282610b91565b610bec8185610b9c565b9350610bfc818560208601610bad565b610c05816108fe565b840191505092915050565b610c1981610a3a565b82525050565b610c2881610a70565b82525050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b60058110610c6e57610c6d610c2e565b5b50565b6000819050610c7f82610c5d565b919050565b6000610c8f82610c71565b9050919050565b610c9f81610c84565b82525050565b600060c082019050610cba6000830189610b82565b8181036020830152610ccc8188610bd7565b9050610cdb6040830187610c10565b610ce86060830186610c1f565b610cf56080830185610c1f565b610d0260a0830184610c96565b979650505050505050565b610d1681610b70565b8114610d2157600080fd5b50565b600081359050610d3381610d0d565b92915050565b600060208284031215610d4f57610d4e6108ea565b5b6000610d5d84828501610d24565b91505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610dad57607f821691505b602082108103610dc057610dbf610d66565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302610e287fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610deb565b610e328683610deb565b95508019841693508086168417925050509392505050565b6000819050919050565b6000610e6f610e6a610e6584610a3a565b610e4a565b610a3a565b9050919050565b6000819050919050565b610e8983610e54565b610e9d610e9582610e76565b848454610df8565b825550505050565b600090565b610eb2610ea5565b610ebd818484610e80565b505050565b5b81811015610ee157610ed6600082610eaa565b600181019050610ec3565b5050565b601f821115610f2657610ef781610dc6565b610f0084610ddb565b81016020851015610f0f578190505b610f23610f1b85610ddb565b830182610ec2565b50505b505050565b600082821c905092915050565b6000610f4960001984600802610f2b565b1980831691505092915050565b6000610f628383610f38565b9150826002028217905092915050565b610f7b82610b91565b67ffffffffffffffff811115610f9457610f9361090f565b5b610f9e8254610d95565b610fa9828285610ee5565b600060209050601f831160018114610fdc5760008415610fca578287015190505b610fd48582610f56565b86555061103c565b601f198416610fea86610dc6565b60005b8281101561101257848901518255600182019150602085019450602081019050610fed565b8683101561102f578489015161102b601f891682610f38565b8355505b6001600288020188555050505b50505050505056fea26469706673582212208179c9868805d310e4ad83ad1fd4174a512e4fac53079da5df21a89ededd819564736f6c63430008110033";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_GET = "get";

    public static final String FUNC_GET_BY_ADDRESS = "get_by_address";

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