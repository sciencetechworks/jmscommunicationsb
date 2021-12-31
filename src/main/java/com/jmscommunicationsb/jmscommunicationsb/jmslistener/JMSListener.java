
package com.jmscommunicationsb.jmscommunicationsb.jmslistener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.SendTo;
/**
 *          ScienceTechWorks
 * @author Ramon.Talavera@gmail.com 
 */
@Component
@Slf4j
public class JMSListener {

	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(final Message txtMessage) throws JMSException {
                log.info("INBOUND: Received Message:"+((TextMessage)txtMessage).getText());
                String response="Response to:"+((TextMessage)txtMessage).getText();
		return response;
	}

}