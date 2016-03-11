import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

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
        final Document document = editor.getDocument();
        if (!document.isWritable()){
            Messages.showInfoMessage("This file is readonly !","Insert Date Here Plugin : ");
            return ;
        }
        CaretModel caretModel = editor.getCaretModel();
        final int offset = caretModel.getOffset();
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
