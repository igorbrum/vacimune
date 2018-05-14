package rn;

import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;
import entity.Watson;

/**
 *
 * @author ibrum
 */
public class WatsonRN {
    private static final String VERSION = "2018-02-16";
    private static final String USER = "b4dd4f12-9a69-4b29-b9c5-ad00017199ea";
    private static final String PASSWORD = "l7dg2IXlDq08";
    private static final String WORKSPACE = "3d21a7ca-aeda-4704-9c34-47a6ac7a3163";
    
    public OutputData sendMessage(Watson watson){
        Conversation service = new Conversation(VERSION, USER, PASSWORD);
        InputData input = new InputData.Builder(watson.getInput()).build();
        MessageOptions options = new MessageOptions.Builder(WORKSPACE).input(input).build();
        MessageResponse response = service.message(options).execute();
        return response.getOutput();
    }
}
