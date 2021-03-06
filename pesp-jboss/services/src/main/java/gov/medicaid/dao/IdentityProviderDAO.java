/*
 * Copyright (C) 2012 TopCoder Inc., All Rights Reserved.
 */
package gov.medicaid.dao;

import gov.medicaid.entities.CMSUser;
import gov.medicaid.services.PortalServiceException;

import java.util.List;

/**
 * This service defines the API used to synchronize application users with the Identity provider.
 *
 * @author TCSASSEMBLER
 * @version 1.0
 */
public interface IdentityProviderDAO {

    /**
     * Asks the identity provider to provision a new user with the given profile and password.
     *
     * @param user the user to be provisioned
     * @param password the password for the user
     * @throws PortalServiceException for any errors encountered
     */
    void provisionUser(CMSUser user, String password) throws PortalServiceException;

    /**
     * Updates the profile of the user on the external provider.
     *
     * @param user the profile to be updated (it is assumed username is never changed)
     * @throws PortalServiceException for any errors encountered
     */
    void updateUser(CMSUser user) throws PortalServiceException;

    /**
     * Removes the user from the underlying identity provider.
     *
     * @param username this is the user that will be permanently removed
     * @throws PortalServiceException for any errors encountered
     */
    void removeUser(String username) throws PortalServiceException;

    /**
     * Authenticates the given user.
     *
     * @param username the username
     * @param password the password
     * @return true if the user was successfully authenticated
     * @throws PortalServiceException for any errors encountered
     */
    boolean authenticate(String username, String password) throws PortalServiceException;

    /**
     * Resets the password for the given user.
     *
     * @param username the username
     * @param password the new password
     * @throws PortalServiceException for any errors encountered
     */
    void resetPassword(String username, String password) throws PortalServiceException;

    /**
     * Retrieves the roles for the from the identity provider.
     *
     * @param username the user to get the roles for
     * @return the list of roles for the user
     * @throws PortalServiceException for any errors encountered
     */
    List<String> findRoles(String username) throws PortalServiceException;

}
