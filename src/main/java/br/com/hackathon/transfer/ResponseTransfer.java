package br.com.hackathon.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseTransfer {
    private Duration performance;
    private String message;
}
