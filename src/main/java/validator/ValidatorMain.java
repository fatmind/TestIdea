package validator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ValidatorMain {

	public static void main(String[] args) {
		
		ValidatorMain main = new ValidatorMain();
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		TempTO tt = main.new TempTO();
		tt.setName("heloo");
		tt.setAge(-1L);
		Set<ConstraintViolation<TempTO>> res = validator.validate(tt);
		Iterator<ConstraintViolation<TempTO>> i = res.iterator();
		while(i.hasNext()) {
			ConstraintViolation<TempTO> cv = i.next();
			System.out.println(cv);
		}
		
	}
	
	
	class TempTO {
		
		@NotNull
		private String name;
		
		@NotNull
		@Min(0)
		private Long age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getAge() {
			return age;
		}

		public void setAge(Long age) {
			this.age = age;
		}
		
	}

}
