package edu.bsuir.beans;

import edu.bsuir.model.Film;
import edu.bsuir.model.FilmView;
import edu.bsuir.model.Picture;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Time startDuration;
	private Time endDuration;
	private String[] genre;
	private String country;
	private Year year;
	private Time startTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSayWelcome(){
		//check if null?
		if("".equals(name) || name == null){
			return "";
		}else{
			return "Ajax message : Welcome " + name;
		}
	}

	public List<FilmView> getFilms() {

		List<Film> filmList = new ArrayList<Film>();
		Film tempFilm = new Film(1,name, new Time(1), "qwe", "Bel", Year.of(2016), 1);
		filmList.add(tempFilm);
		/*List<Film> filmList = new FilterView(name, new Time(1), new Time(1), new String[]{"qwe", "zcx", "asd"}, "Bel", Year.of(2016), new Time(1));*/
		List<FilmView> filmViewList = new ArrayList<FilmView>();
		for(Film film : filmList) {
			filmViewList.add(new FilmView(film, new Picture(1, "test", "test", 1, 1)));
		}

		return filmViewList;
	}

	public void showMessage() {
		FacesMessage message = new FacesMessage("Подтверждение", "Да");
		message.setSeverity(FacesMessage.SEVERITY_INFO); //как выглядит окошко с сообщением
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Time getStartDuration() {
		return startDuration;
	}

	public void setStartDuration(Time startDuration) {
		this.startDuration = startDuration;
	}

	public Time getEndDuration() {
		return endDuration;
	}

	public void setEndDuration(Time endDuration) {
		this.endDuration = endDuration;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
}