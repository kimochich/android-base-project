package co.lateralview.myapp.domain.repository.interfaces;

import co.lateralview.myapp.domain.model.User;

/*
 To save the current user in the device. This repository doesn't make server calls.
 */
public interface SessionRepository
{
    //TODO Do this reactive (SharedPreferences cause I/O Block)

    boolean isUserLoggedIn();

    void logOut();

    void logIn(User user, String accessToken);

    User getCurrentUser();

    void updateUser(User user);

    String getAccessToken();
}
