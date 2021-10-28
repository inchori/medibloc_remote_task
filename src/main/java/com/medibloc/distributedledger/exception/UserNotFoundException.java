package com.medibloc.distributedledger.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super("해당 고객이 존재하지 않습니다.");
    }
}
