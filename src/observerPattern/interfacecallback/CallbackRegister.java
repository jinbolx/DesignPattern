package observerPattern.interfacecallback;

public class CallbackRegister {

    OnCallback onCallback;

    public void registerCallback(OnCallback onCallback) {
        this.onCallback = onCallback;
    }
}
