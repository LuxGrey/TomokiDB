package luxgrey.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import luxgrey.model.Identity;

public class IdentityEditController {
  @FXML
  private TextArea note;
  private EntityManager em;
  private Identity identity;

  public void setData(EntityManager em, Identity identity) {
    this.em = em;
    this.identity = identity;
    bindIdentity(identity);
  }

  private void bindIdentity(Identity identity) {
    note.textProperty().bindBidirectional(identity.noteProperty());
  }

  @FXML
  private void saveButtonAction(ActionEvent event) {
    em.getTransaction().commit();
    em.close();

    closeStage(event);
  }

  @FXML
  private void cancelButtonAction(ActionEvent event) {
    em.getTransaction().rollback();
    em.close();

    closeStage(event);
  }

  private void closeStage(ActionEvent event) {
    ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
  }
}
