package luxgrey.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.persistence.EntityManager;
import luxgrey.App;
import luxgrey.PersistenceHelper;
import luxgrey.model.Identity;

public class IdentityListController {

  public void refresh() {
  }

  @FXML
  private void showTagSelectModal(ActionEvent event) throws IOException {
    Parent root = App.loadFXML("TagSelect");
    Stage modalStage = createModal(event, root, "Tags");
    modalStage.show();
  }

  @FXML
  private void showAddIdentityModal(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = App.createFXMLLoader("IdentityEdit");
    Parent root = fxmlLoader.load();
    Stage modalStage = createModal(event, root,"Add new Identity");
    modalStage.setMinHeight(100);
    modalStage.setMinWidth(100);

    IdentityEditController controller = fxmlLoader.getController();
    EntityManager em = PersistenceHelper.createEntityManager();

    modalStage.setOnCloseRequest(closeRequestEvent -> {
      em.getTransaction().rollback();
      em.close();
    });

    em.getTransaction().begin();
    controller.setData(em, new Identity());

    modalStage.show();
  }

  private Stage createModal(ActionEvent event, Parent root, String stageTitle) {
    Stage modalStage = new Stage();
    modalStage.setTitle(stageTitle);

    modalStage.setScene(new Scene(root));
    modalStage.initModality(Modality.APPLICATION_MODAL);
    modalStage.initOwner(
        ( (Node) event.getSource() ).getScene().getWindow() );
    // refresh Identity-list when modal is closed
    // modalStage.setOnHidden(refreshParentEvent -> refresh());

    return modalStage;
  }
}
