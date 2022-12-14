package br.com.hackathon.controller;

import br.com.hackathon.constant.Constants;
import br.com.hackathon.helper.TimeHelper;
import br.com.hackathon.service.Web3Service;
import br.com.hackathon.transfer.AccountDTO;
import br.com.hackathon.transfer.ResponseTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static br.com.hackathon.constant.Constants.*;

@Slf4j
@RestController
public class EthereumRestController {
    @Autowired
    Web3Service web3Service;

    @RequestMapping(value = Constants.API_BLOCK, method = RequestMethod.GET)
    public Future<ResponseTransfer> getBlock() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();

        return CompletableFuture.supplyAsync(() -> {
            try {
                EthBlockNumber result = web3Service.getBlockNumber();
                responseTransfer.setMessage(result.toString());
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = Constants.API_ACCOUNTS, method = RequestMethod.GET)
    public Future<ResponseTransfer> getAccounts() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();

        return CompletableFuture.supplyAsync(() -> {
            try {
                EthAccounts result = web3Service.getEthAccounts();
                responseTransfer.setMessage(result.toString());
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;

        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = Constants.API_TRANSACTIONS, method = RequestMethod.GET)
    public Future<ResponseTransfer> getTransactions() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                EthGetTransactionCount result = web3Service.getTransactionCount();
                responseTransfer.setMessage(result.toString());
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = Constants.API_BALANCE, method = RequestMethod.GET)
    public Future<ResponseTransfer> getBalance() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                EthGetBalance result = web3Service.getEthBalance();
                responseTransfer.setMessage(result.toString());
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = Constants.API_CONTRACT, method = RequestMethod.GET)
    public Future<ResponseTransfer> getContractAddress() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                var result = web3Service.getContractAddress();
                responseTransfer.setMessage(result);
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_SEND_TRANSACTION, method = RequestMethod.GET)
    public CompletableFuture<ResponseTransfer> sendEthereumTransaction() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                var result = web3Service.sendEthereumTransaction();
                responseTransfer.setMessage(result);
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_DEPLOY_CONTRACT_DEVELOPER, method = RequestMethod.GET)
    public CompletableFuture<ResponseTransfer> deployContractDeveloper() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                var result = web3Service.deployContractDeveloper();
                responseTransfer.setMessage(result);
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_DEPLOY_CONTRACT_MANAGER, method = RequestMethod.GET)
    public CompletableFuture<ResponseTransfer> deployContractManageDev() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                var result = web3Service.deployContractManageDev();
                responseTransfer.setMessage(result);
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_PERFORM_TRANSFER, method = RequestMethod.GET)
    public CompletableFuture<ResponseTransfer> performTransfer() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                var response = web3Service.performTransfer();
                responseTransfer.setMessage(response.getStatus());
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_TRANSFER_FUNDS, method = RequestMethod.POST)
    public CompletableFuture<ResponseTransfer> transferFunds(@RequestBody AccountDTO account) {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        return CompletableFuture.supplyAsync(() -> {
            try {
                web3Service.transferFunds(account);
                responseTransfer.setMessage(SUCCESSFULLY_TRANSFERRED);
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).thenApplyAsync(result -> {
            result.setPerformance(TimeHelper.stop(start));
            return result;
        });
    }

    @RequestMapping(value = API_ACCOUNT_LIST, method = RequestMethod.GET)
    public ResponseTransfer listAccounts() {
        ResponseTransfer responseTransfer = new ResponseTransfer();
        Instant start = TimeHelper.start();
        ResponseTransfer accounts = CompletableFuture.supplyAsync(() -> {
            try {
                EthAccounts result = web3Service.getEthAccounts();
                List<AccountDTO> accountList = web3Service.populateAccountList(result.getResult());
                accountList = web3Service.getAllEthBalances(accountList);

                responseTransfer.setAccounts(accountList);
                responseTransfer.setMessage(result.toString());
                responseTransfer.setPerformance(TimeHelper.stop(start));
            } catch (Exception e) {
                responseTransfer.setMessage(GENERIC_EXCEPTION);
            }
            return responseTransfer;
        }).join();
        return accounts;
    }
}
