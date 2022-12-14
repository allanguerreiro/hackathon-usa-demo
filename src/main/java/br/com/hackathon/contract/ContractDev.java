package br.com.hackathon.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
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
public class ContractDev extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610c88806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80633ea168df146100465780636ddcf8fc146100645780638e50e24614610080575b600080fd5b61004e6100b0565b60405161005b9190610521565b60405180910390f35b61007e600480360381019061007991906105ae565b6100f6565b005b61009a600480360381019061009591906105ae565b610421565b6040516100a791906105f6565b60405180910390f35b60008060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff160361012f57600080fd5b6000806000806000807367d269191c92caf3cd7723f116c85e6e9bf5593373ffffffffffffffffffffffffffffffffffffffff1663b96b099f886040518263ffffffff1660e01b81526004016101859190610620565b600060405180830381865afa1580156101a2573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052508101906101cb919061082e565b95509550955095509550955060006040518060c001604052808873ffffffffffffffffffffffffffffffffffffffff1681526020018781526020018681526020018515158152602001841515815260200183600481111561022f5761022e6108d7565b5b8152509050846000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461027e9190610935565b6000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190816103999190610b80565b506040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555060808201518160030160016101000a81548160ff02191690831515021790555060a08201518160030160026101000a81548160ff0219169083600481111561040f5761040e6108d7565b5b02179055509050505050505050505050565b60008073ffffffffffffffffffffffffffffffffffffffff16600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146104fe5760019050610503565b600090505b919050565b6000819050919050565b61051b81610508565b82525050565b60006020820190506105366000830184610512565b92915050565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061057b82610550565b9050919050565b61058b81610570565b811461059657600080fd5b50565b6000813590506105a881610582565b92915050565b6000602082840312156105c4576105c3610546565b5b60006105d284828501610599565b91505092915050565b60008115159050919050565b6105f0816105db565b82525050565b600060208201905061060b60008301846105e7565b92915050565b61061a81610570565b82525050565b60006020820190506106356000830184610611565b92915050565b60008151905061064a81610582565b92915050565b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6106a38261065a565b810181811067ffffffffffffffff821117156106c2576106c161066b565b5b80604052505050565b60006106d561053c565b90506106e1828261069a565b919050565b600067ffffffffffffffff8211156107015761070061066b565b5b61070a8261065a565b9050602081019050919050565b60005b8381101561073557808201518184015260208101905061071a565b60008484015250505050565b600061075461074f846106e6565b6106cb565b9050828152602081018484840111156107705761076f610655565b5b61077b848285610717565b509392505050565b600082601f83011261079857610797610650565b5b81516107a8848260208601610741565b91505092915050565b6107ba81610508565b81146107c557600080fd5b50565b6000815190506107d7816107b1565b92915050565b6107e6816105db565b81146107f157600080fd5b50565b600081519050610803816107dd565b92915050565b6005811061081657600080fd5b50565b60008151905061082881610809565b92915050565b60008060008060008060c0878903121561084b5761084a610546565b5b600061085989828a0161063b565b965050602087015167ffffffffffffffff81111561087a5761087961054b565b5b61088689828a01610783565b955050604061089789828a016107c8565b94505060606108a889828a016107f4565b93505060806108b989828a016107f4565b92505060a06108ca89828a01610819565b9150509295509295509295565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061094082610508565b915061094b83610508565b925082820190508082111561096357610962610906565b5b92915050565b600081519050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806109bb57607f821691505b6020821081036109ce576109cd610974565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302610a367fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826109f9565b610a4086836109f9565b95508019841693508086168417925050509392505050565b6000819050919050565b6000610a7d610a78610a7384610508565b610a58565b610508565b9050919050565b6000819050919050565b610a9783610a62565b610aab610aa382610a84565b848454610a06565b825550505050565b600090565b610ac0610ab3565b610acb818484610a8e565b505050565b5b81811015610aef57610ae4600082610ab8565b600181019050610ad1565b5050565b601f821115610b3457610b05816109d4565b610b0e846109e9565b81016020851015610b1d578190505b610b31610b29856109e9565b830182610ad0565b50505b505050565b600082821c905092915050565b6000610b5760001984600802610b39565b1980831691505092915050565b6000610b708383610b46565b9150826002028217905092915050565b610b8982610969565b67ffffffffffffffff811115610ba257610ba161066b565b5b610bac82546109a3565b610bb7828285610af3565b600060209050601f831160018114610bea5760008415610bd8578287015190505b610be28582610b64565b865550610c4a565b601f198416610bf8866109d4565b60005b82811015610c2057848901518255600182019150602085019450602081019050610bfb565b86831015610c3d5784890151610c39601f891682610b46565b8355505b6001600288020188555050505b50505050505056fea26469706673582212205a18a02c723f17b4bcc6a36417cba669fadc431208270e7b07b670eb111bb60f64736f6c63430008110033";

    public static final String FUNC_GET_TOTAL_COST = "get_total_cost";

    public static final String FUNC_IS_DEVELOPER_CONTRACTED = "is_developer_contracted";

    public static final String FUNC_NEW_CONTRACT = "new_contract";

    @Deprecated
    protected ContractDev(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContractDev(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContractDev(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContractDev(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> get_total_cost() {
        final Function function = new Function(FUNC_GET_TOTAL_COST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> is_developer_contracted(String _developer) {
        final Function function = new Function(FUNC_IS_DEVELOPER_CONTRACTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _developer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> new_contract(String _developer) {
        final Function function = new Function(
                FUNC_NEW_CONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _developer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ContractDev load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContractDev(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContractDev load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContractDev(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContractDev load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ContractDev(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContractDev load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContractDev(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContractDev> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContractDev.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContractDev> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContractDev.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ContractDev> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContractDev.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContractDev> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContractDev.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
