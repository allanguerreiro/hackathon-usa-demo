package br.com.hackathon.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountDTO {
    private String address;
    private String privateKey;
    private BigDecimal balance;
    private Double transferValue;
    private String transferFromPrivateKey;
    private String transferToAddress;

    public AccountDTO(List<String> addresses) {
        this.address = address;
    }
}
