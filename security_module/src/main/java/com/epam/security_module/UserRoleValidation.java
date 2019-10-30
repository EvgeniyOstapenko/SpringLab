package com.epam.security_module;


public class UserRoleValidation {
    private static final String USER_ROLE = "ADMIN_USER";

    public static boolean isValidUserRole(String userRole) throws UnauthorizedAccessAttemptException {
        if(userRole.equals(USER_ROLE)) return true;
        else throw new UnauthorizedAccessAttemptException("Access is denied!");
    }
}
