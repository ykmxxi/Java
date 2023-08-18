package ch11.값이없는상황;

public class NullStateEx {

	// null 안전 시도 1: 깊은 의심, 필요한 곳에 null 체크 코드를 넣는다
	public static String getCarInsuranceName1(Person person) {
		if (person != null) {
			Car car = person.getCar();
			if (car != null) {
				Insurance insurance = car.getInsurance();
				if (insurance != null) {
					return insurance.getName();
				}
			}
		}
		return "Unknown";
	}

	// null 안전 시도 2: 너무 많은 출구
	public static String getCarInsuranceName2(Person person) {
		if (person == null) {
			return "Unknown";
		}

		Car car = person.getCar();
		if (car == null) {
			return "Unknown";
		}

		Insurance insurance = car.getInsurance();
		if (insurance == null) {
			return "Unknown";
		}
		return insurance.getName();
	}

	public static void main(String[] args) {
		String result1 = getCarInsuranceName1(new Person());
		System.out.println("result1 = " + result1);
	}

}
