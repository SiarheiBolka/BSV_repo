public class MyComparator implements java.util.Comparator<String> {

	//TODO Variable is not initialized
    private int referenceLength;

	//TODO Method is not used
    public MyComparator(String reference) {
        super();
        this.referenceLength = reference.length();
    }

    public MyComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(String s1, String s2) {
		//TODO What is referenceLength variable?
        int dist1 = Math.abs(s1.length() - referenceLength);
        int dist2 = Math.abs(s2.length() - referenceLength);

        return dist1 - dist2;
    }
}
