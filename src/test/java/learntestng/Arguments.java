package learntestng;

import org.testng.annotations.Test;

public  class Arguments {
	@Test
	public void ethan() {
		System.out.println("ethan has entered");

	}
   
   @Test

	public void benji() {
		System.out.println("benji has entered");
	}

   @Test(dependsOnMethods = {"ethan"})
	public void ilsa() {
		System.out.println("ilsa has entered");
	}
@Test(enabled = false)
	public void lane() {
		System.out.println("lane has entered");
	}

}


