package luxgrey.controller;

import jakarta.persistence.EntityManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import luxgrey.PersistenceHelper;
import luxgrey.model.Identity;

public class IdentityEditController {
  @FXML
  private TextArea note;
  private EntityManager em;
  private Identity identity;

  public IdentityEditController() {
    this.em = PersistenceHelper.createEntityManager();
  }

  public void setIdentity(Identity identity) {
    this.identity = identity;
    bindIdentity(identity);
  }

  private void bindIdentity(Identity identity) {
    note.textProperty().bindBidirectional(identity.noteProperty());
  }
}
