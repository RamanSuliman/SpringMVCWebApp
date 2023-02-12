package reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class ReservationController 
{
	@RequestMapping("/bookingForm")
	public String bookingForm(Model model)
	{
		//Instantiate a reservation object.
		Reservation reservation = new Reservation();
		//Add the reservation object to the model.
		model.addAttribute("reservationObject", reservation);
		//Return the booking page
		return "Reservation/ReservationForm";
	}
		
	/* The value passed with the @ModelAttribute annotation should be the same to 
	 * the modelAttribute value present in the view page. */
	@RequestMapping("/submitReservationForm")
	public String submitForm(@ModelAttribute("reservationObject") Reservation res)
	{
		return "Reservation/Confirmation";
	}
}
