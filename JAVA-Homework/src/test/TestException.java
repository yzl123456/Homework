package test;

public class TestException {
	String error=new String();
	public void testExce(){
		try {
			throw new Exception("aaa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}
}
