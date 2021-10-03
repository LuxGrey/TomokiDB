package luxgrey.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "weblinks")
public class Weblink implements Externalizable {

  private int id;
  private StringProperty url;
  private String _url;
  private Identity identity;

  public Weblink() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    if (url == null) {
      return _url;
    } else {
      return url.get();
    }
  }

  public void setUrl(String url) {
    if(this.url == null) {
      _url = url;
    } else {
      this.url.set(url);
    }
  }

  public StringProperty urlProperty() {
    if (url == null) {
      url = new SimpleStringProperty(this, "url", _url);
    }
    return url;
  }

  @ManyToOne
  public Identity getIdentity() {
    return identity;
  }

  public void setIdentity(Identity identity) {
    this.identity = identity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Weblink weblink = (Weblink) o;
    return id == weblink.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(getId());
    out.writeObject(getUrl());
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    setId(in.readInt());
    setUrl((String) in.readObject());
  }
}
