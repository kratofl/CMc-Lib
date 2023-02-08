package kratofl.cmclib.advancements.objs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kratofl.cmclib.advancements.constants.Background;
import kratofl.cmclib.advancements.constants.FrameType;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class Display {
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String background = Background.STONE.toString();
    @Expose
    private Icon icon = new Icon(Material.STONE);
    @Expose
    private String frame = FrameType.TASK.toString();
    @Expose
    @SerializedName("announce_to_chat")
    private boolean announce = true;
    @Expose
    private boolean hidden = false;
    @Expose
    @SerializedName("show_toast")
    private boolean toast = true;

    public Display(String title, String description, Material iconMaterial) {
        setTitle(title);
        setDescription(description);
        setIcon(iconMaterial);
    }
    private void setIcon(Material material) {
        this.icon = new Icon(material);
    }
    private void setTitle(String title) {
        this.title = title;
    }
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param background - default advancement background
     */
    public void setBackground(Background background) {
        this.background = background.toString();
    }
    /**
     * @param background - path from a minecraft texture
     */
    public void setBackground(String background) {
        this.background = background;
    }

    public void setFrame(FrameType frame) {
        this.frame = frame.toString();
    }

    public void disableChatAnnouncement() {
        this.announce = false;
    }

    public void hide() {
        this.hidden = true;
    }

    public void disableToast() {
        this.toast = false;
    }

    public boolean isBackgroundSet() {
        return background != null;
    }
}
