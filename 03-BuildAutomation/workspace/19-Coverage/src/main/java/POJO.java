public final class POJO {
    private int number;
    private final String descriptor;
    
    public POJO(final int number, final String descriptor) {
        this.number = number;
        this.descriptor = descriptor;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int otherNumber) {
        this.number = otherNumber;
    }
    public String getDescription() {
        return descriptor;
    }
    @Override public boolean equals(Object other) {
        if (other instanceof POJO) {
            final POJO pojo = (POJO) other;
            return number == pojo.number && descriptor.equals(pojo.descriptor);
        }
        return false;
    }
    @Override public int hashCode() {
        return number ^ descriptor.hashCode();
    }

}
