package hibi.vhcompanion;

import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("hello, world");
    }
}
