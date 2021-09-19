package luxgrey.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import luxgrey.App;

public class IdentityListController {
  @FXML
  private void showTagSelectModal(ActionEvent event) throws IOException {
    Stage modalStage = new Stage();
    modalStage.setTitle("Tags");
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TagSelect.fxml"));
    Parent root = fxmlLoader.load();

    modalStage.setScene(new Scene(root));
    modalStage.setTitle("Tags");
    modalStage.initModality(Modality.APPLICATION_MODAL);
    modalStage.initOwner(
        ( (Node) event.getSource() ).getScene().getWindow() );

    modalStage.show();
  }
}
