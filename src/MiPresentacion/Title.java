package MiPresentacion;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title (String title, Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }


}
