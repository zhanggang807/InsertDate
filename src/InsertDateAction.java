import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Insert Date Action
 * Created by zhanggang3 on 2016/3/10.
 */
public class InsertDateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent actionEvent){
        Editor editor = actionEvent.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        final int offset = caretModel.getOffset();
        final Document document = editor.getDocument();
        Project project = editor.getProject();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(new Date());
                document.insertString(offset, "// modified by zhanggang at " + dateStr + ".");
            }
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
        caretModel.moveToOffset(offset + 2, false);
    }

}
