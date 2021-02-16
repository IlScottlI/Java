public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	return this.getRingTone();
    }
	@Override
    public String unlock() {
    	return "Unlock via facial recognition";
    }
    @Override
    public void displayInfo() {
        System.out.println("iPhone " + super.getVersionNumber() + " from " + super.getCarrier());                
    }
}
