/**
 * ResponseStatus
 *
 * 0.0.1
 *
 * 2024.01.23
 *
 * Majorfolio
 */
package com.redispractice.kuitaos.reponse.status;

public interface ResponseStatus {
    int getCode();

    int getStatus();

    String getMessage();
}
