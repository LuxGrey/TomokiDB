package luxgrey.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "identities")
public class Identity implements Externalizable {

  private int id;
  private StringProperty note;
  private String _note;
  private Collection<Weblink> weblinks = new HashSet<>();
  private Collection<IdentityTag> tags = new HashSet<>();
  private Collection<Alias> aliases = new HashSet<>();

  public Identity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNote() {
    if (note == null) {
      return _note;
    } else {
      return note.get();
    }
  }

  public void setNote(String note) {
    if (this.note == null) {
      _note = note;
    } else {
      this.note.set(note);
    }
  }

  public StringProperty noteProperty() {
    if (note == null) {
      note = new SimpleStringProperty(this, "note", _note);
    }
    return note;
  }

  @OneToMany(mappedBy = "identity")
  public Collection<Weblink> getWeblinks() {
    return weblinks;
  }

  public void setWeblinks(Collection<Weblink> weblinks) {
    this.weblinks = weblinks;
  }

  @OneToMany(mappedBy = "identity")
  public Collection<IdentityTag> getTags() {
    return tags;
  }

  public void setTags(Collection<IdentityTag> tags) {
    this.tags = tags;
  }

  @OneToMany(mappedBy = "identity")
  public Collection<Alias> getAliases() {
    return aliases;
  }

  public void setAliases(Collection<Alias> aliases) {
    this.aliases = aliases;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return id == identity.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(getId());
    out.writeObject(getNote());
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    setId(in.readInt());
    setNote((String) in.readObject());
  }
}
