package luxgrey.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Serves as a pivot entity for the many-to-many relationship between Identity and Tag.
 * This entity exists only to allow Identity and Tag to properly implement Externalizable.
 */
@Entity
@Table(name = "identity_tags")
public class IdentityTag {
  @EmbeddedId
  private IdentityTagKey id;

  @ManyToOne
  @MapsId("identityId")
  @JoinColumn(name = "identity_id")
  private Identity identity;

  @ManyToOne
  @MapsId("tagId")
  @JoinColumn(name = "tag_id")
  private Tag tag;

  public IdentityTagKey getId() {
    return id;
  }

  public void setId(IdentityTagKey id) {
    this.id = id;
  }

  public Identity getIdentity() {
    return identity;
  }

  public void setIdentity(Identity identity) {
    this.identity = identity;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }
}
