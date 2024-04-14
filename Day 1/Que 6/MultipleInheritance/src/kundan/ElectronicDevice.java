package kundan;


interface ElectronicDevice {
    
    void powerOn();
    void powerOff();
}

interface HandheldDevice extends ElectronicDevice {
    void carry();
}

interface Smartphone extends HandheldDevice {
    void makeCall();
    void sendText();
}

interface Tablet extends HandheldDevice {
    void browseInternet();
    void playGames();
}

interface HybridDevice extends Smartphone, Tablet {
    @Override
    void makeCall();

    @Override
    void sendText();

    @Override
    void browseInternet();

    @Override
    void playGames();
}

class MyElectronicDevice implements ElectronicDevice {
    public void powerOn() {
        System.out.println("Electronic device powered on");
    }

    public void powerOff() {
        System.out.println("Electronic device powered off");
    }
}

class MyHandheldDevice implements HandheldDevice {
    public void powerOn() {
        System.out.println("Handheld device powered on");
    }

    public void powerOff() {
        System.out.println("Handheld device powered off");
    }

    public void carry() {
        System.out.println("Carrying handheld device");
    }
}

class MySmartphone implements Smartphone {
    public void powerOn() {
        System.out.println("Smartphone powered on");
    }

    public void powerOff() {
        System.out.println("Smartphone powered off");
    }

    public void carry() {
        System.out.println("Carrying smartphone");
    }

    public void makeCall() {
        System.out.println("Making a call");
    }

    public void sendText() {
        System.out.println("Sending a text message");
    }
}

class MyTablet implements Tablet {
    public void powerOn() {
        System.out.println("Tablet powered on");
    }

    public void powerOff() {
        System.out.println("Tablet powered off");
    }

    public void carry() {
        System.out.println("Carrying tablet");
    }

    public void browseInternet() {
        System.out.println("Browsing the internet");
    }

    public void playGames() {
        System.out.println("Playing games");
    }
}

class MyHybridDevice implements HybridDevice {
    public void powerOn() {
        System.out.println("Hybrid device powered on");
    }

    public void powerOff() {
        System.out.println("Hybrid device powered off");
    }

    public void carry() {
        System.out.println("Carrying hybrid device");
    }

    public void makeCall() {
        System.out.println("Making a call");
    }

    public void sendText() {
        System.out.println("Sending a text message");
    }

    public void browseInternet() {
        System.out.println("Browsing the internet");
    }

    public void playGames() {
        System.out.println("Playing games");
    }
}



