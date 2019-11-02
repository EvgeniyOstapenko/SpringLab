package com.epam.security_module;


public class SecurityService {

    private SecurityStorage securityStorage;

    public SecurityService(SecurityStorage securityStorage) {
        this.securityStorage = securityStorage;
    }

    public boolean isValidUserRole(String userRole) throws UnauthorizedAccessAttemptException {
        if(userRole.equals(securityStorage.getADMIN())) return true;
        else throw new UnauthorizedAccessAttemptException("Access is denied!");
    }
}
