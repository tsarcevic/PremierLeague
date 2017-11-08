package com.example.cobeosijek.premierleague.team_list;

import com.example.cobeosijek.premierleague.TestUtils;
import com.example.cobeosijek.premierleague.data.models.Team;
import com.example.cobeosijek.premierleague.networking.NetworkInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import retrofit2.Callback;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by cobeosijek on 08/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TeamListPresenterTest {

    @Mock
    NetworkInterface networkInterface;

    @Mock
    TeamListInterface.View view;

    TeamListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new TeamListPresenter(networkInterface);
        presenter.setView(view);
    }

    @Test
    public void testViewReady() throws Exception {
        presenter.viewReady();

        verify(networkInterface).getAllTeams(any(Callback.class));
        verifyNoMoreInteractions(view, networkInterface);
    }

    @Test
    public void testListRefresh() throws Exception {
        presenter.listRefresh();

        verify(view).showRefreshing();
        verify(networkInterface).getAllTeams(any(Callback.class));
        verifyNoMoreInteractions(view, networkInterface);
    }

    @Test
    public void testItemSelectedListNullShouldNoop() throws Exception {
        presenter.teamList = null;

        presenter.listItemSelected(0);

        verifyZeroInteractions(view, networkInterface);
    }

    @Test
    public void testItemSelectedListOutOfBoundsShouldNoop() throws Exception {
        presenter.teamList = TestUtils.generateTeamList();

        presenter.listItemSelected(5);

        verifyZeroInteractions(view, networkInterface);
    }

    @Test
    public void testItemSelectedListOkShouldStartTeamDetails() throws Exception {
        presenter.teamList = TestUtils.generateTeamList();

        presenter.listItemSelected(4);

        verify(view).openTeamDetails(any(Team.class));
        verifyNoMoreInteractions(view, networkInterface);
    }

    @Test
    public void testListenerResponse() throws Exception {
    }
}