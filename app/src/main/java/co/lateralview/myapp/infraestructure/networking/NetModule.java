package co.lateralview.myapp.infraestructure.networking;

import android.app.Application;

import net.lateralview.simplerestclienthandler.RestClientManager;
import net.lateralview.simplerestclienthandler.base.RequestFutureHandler;

import javax.inject.Singleton;

import co.lateralview.myapp.infraestructure.networking.implementation.UserServerImpl;
import co.lateralview.myapp.infraestructure.networking.interfaces.UserServer;
import dagger.Module;
import dagger.Provides;

@Module
public class NetModule
{
    @Provides
    @Singleton
    public RestClientManager provideRestClient(Application application)
    {
        RestClientManager.initialize(application);

        RequestFutureHandler.setServerErrorClass(
                MyAppServerError.class); //Default Server Error Class

        return RestClientManager.getInstance()
                .enableDebugLog(true);
    }

    @Provides
    @Singleton
    public UserServer provideUserServer(RestClientManager restClientManager)
    {
        return new UserServerImpl(restClientManager);
    }

}