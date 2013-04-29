import org.adam.domain.PetDao;
import org.adam.domain.UserDao;
import org.adam.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 4/16/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  @Mock
  private UserDao userDaoMock;
  @Mock
  private PetDao petDaoMock;
  @InjectMocks
  private UserService classUnderTest = new UserService();


  @Test
  public void shouldSaveUser() {
    //given
    doThrow(new NullPointerException()).when(userDaoMock).saveUser(null);

    //when
    classUnderTest.addUser(null);
    //then
    //no exception thrown
  }

}
