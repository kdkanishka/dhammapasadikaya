/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package update;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kanishka
 */
public class UpdateDetails {
    JLabel jLabel_updateStatus;
    JLabel jLabel_version;
    JLabel jLabel_updatetype;
    JTextArea jTextArea_updateDescription;
    JLabel jLabel_updateURL;
    JPanel jPanel_update;

    public JLabel getjLabel_updateStatus() {
        return jLabel_updateStatus;
    }

    public void setjLabel_updateStatus(JLabel jLabel_updateStatus) {
        this.jLabel_updateStatus = jLabel_updateStatus;
    }

    public JLabel getjLabel_updateURL() {
        return jLabel_updateURL;
    }

    public void setjLabel_updateURL(JLabel jLabel_updateURL) {
        this.jLabel_updateURL = jLabel_updateURL;
    }

    public JLabel getjLabel_updatetype() {
        return jLabel_updatetype;
    }

    public void setjLabel_updatetype(JLabel jLabel_updatetype) {
        this.jLabel_updatetype = jLabel_updatetype;
    }

    public JLabel getjLabel_version() {
        return jLabel_version;
    }

    public void setjLabel_version(JLabel jLabel_version) {
        this.jLabel_version = jLabel_version;
    }

    public JPanel getjPanel_update() {
        return jPanel_update;
    }

    public void setjPanel_update(JPanel jPanel_update) {
        this.jPanel_update = jPanel_update;
    }

    public JTextArea getjTextArea_updateDescription() {
        return jTextArea_updateDescription;
    }

    public void setjTextArea_updateDescription(JTextArea jTextArea_updateDescription) {
        this.jTextArea_updateDescription = jTextArea_updateDescription;
    }

  
}
