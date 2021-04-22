package testcase.ConversionUnits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConversionUnitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionUnitsApplication.class, args);
	}

	@RestController
	public class Controller {
		@Autowired
		private ConvertUnits convertUnits;

		@GetMapping("/units/si")
		public SIConversion demoMethod(@RequestParam("units") String unitName) {
			return this.convertUnits.resolve(unitName);

		}

	}


}
