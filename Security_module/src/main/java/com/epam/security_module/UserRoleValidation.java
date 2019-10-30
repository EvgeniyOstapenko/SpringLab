package com.epam.security_module;


public class UserRoleValidation {

    private SecurityStorage securityStorage;

    public UserRoleValidation(SecurityStorage securityStorage) {
        this.securityStorage = securityStorage;
    }

    public boolean isValidUserRole(String userRole) throws UnauthorizedAccessAttemptException {
        if(userRole.equals(securityStorage.getADMIN())) return true;
        else throw new UnauthorizedAccessAttemptException("Access is denied!");
    }
}
