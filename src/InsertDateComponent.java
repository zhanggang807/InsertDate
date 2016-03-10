import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * 插入日期的组件
 * Created by zhanggang3 on 2016/2/29.
 */
public class InsertDateComponent implements ApplicationComponent {
    public InsertDateComponent() {

    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "InsertDateComponent";
    }


}