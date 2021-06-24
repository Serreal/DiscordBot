package vinimusbot.app.API.Schedule;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Race {

    private String RaceName;
    private Circuit Circuit;
    private Date Date;
    private Time time;
}
