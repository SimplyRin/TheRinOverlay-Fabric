package net.simplyrin.kzigloader.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.simplyrin.kzigloader.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class CustomClientPlayerEntiry {

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    public void onSendChatMessage(String message, CallbackInfo info) {
        if (message != null && message.startsWith("/")) {
            Main.getInstance().getClientCommandHandler().onChat(message, info);
            return;
        }

    }

}
