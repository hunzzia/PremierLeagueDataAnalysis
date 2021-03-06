package com.epl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epl.mapper.MatchMapper;
import com.epl.service.interfaces.MatchService;
import com.epl.vo.InGamePosition;
import com.epl.vo.MatchCheckKeeper;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchNoTeamName;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
	@Autowired private MatchMapper matchMapper;
	
	@Override
	public String getStadiumByTeamName(String teamName) {
		String stadium = matchMapper.selectStadiumByTeamName(teamName);
		return stadium;
	}

	@Override
	public int addMatch(MatchSchedule matchSchedule) {
		int check = matchMapper.insertMatch(matchSchedule);
		System.out.println("Match schedule 입력 성공? : " + check);
		int matchNo = matchSchedule.getMatchNo();
		return matchNo;
	}

	@Override
	public int addMatchRefree(MatchRefree matchRefree) {
		int check = matchMapper.insertMatchRefree(matchRefree);
		return check;
	}

	@Override
	public List<MatchSchedule> getMatchList() {
		List<MatchSchedule> list = matchMapper.selectMatchList();
		return list;
	}

	@Override
	public MatchSchedule getMatchOne(int matchNo) {
		MatchSchedule matchSchedule = matchMapper.selectMatchOne(matchNo);
		return matchSchedule;
	}
	
	@Override
	public int addMainPlayer(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertMainPlayer(MatchPlayerNo);
		return check;
	}
	
	@Override
	public int addSubPlayer(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertSubPlayer(MatchPlayerNo);
		return check;
	}
	
	@Override
	public int addKeeper(MatchPlayerNo MatchPlayerNo)
	{
		int check = matchMapper.insertKeeper(MatchPlayerNo);
		return check;
	}
	
	@Override
	public MatchCheckKeeper checkKeeper(MatchCheckKeeper matchCheckKeeper)
	{
		MatchCheckKeeper Keeper = matchMapper.selectKeeperInMatch(matchCheckKeeper);
		return Keeper;
	}
	
	@Override
	public MatchPlayer getMatchPlayerOne(MatchPlayer matchPlayer)
	{
		MatchPlayer check = matchMapper.selectmatchPlayerOne(matchPlayer);
		return check;
		
	}
	
	@Override
	public MatchGoalKeeper getMatchGoalKeeperOne(MatchGoalKeeper matchGoalKeeper)
	{
		MatchGoalKeeper check = matchMapper.selectMatchGoalKeeperOne(matchGoalKeeper);
		return check;
	}
	
	@Override
	public int modifyMatchPlayer(MatchPlayer matchPlayer)
	{
		int check = matchMapper.updateMatchPlayer(matchPlayer);
		return check;
	}
	@Override
	public int modifyMatchPlayerT(MatchPlayer matchPlayer)
	{
		int check = matchMapper.updateMatchPlayerT(matchPlayer);
		return check;
	}
	
	@Override
	public int addMatchGoals(MatchGoals matchGoals)
	{
		int check = matchMapper.insertMatchGoals(matchGoals);
		return check;
	}
	
	@Override
	public int addMatchOwnGoals(MatchOwnGoals matchOwnGoals)
	{
		int check = matchMapper.insertMatchOwnGoals(matchOwnGoals);
		return check;
	}
	
	@Override
	public int addMatchResult(MatchResult matchResult)
	{
		int check = matchMapper.insertMatchResult(matchResult);
		return check;
	}
	
	@Override
	public int modifyMatchResultByGoal(MatchGoals matchGoals)
	{
		int check = matchMapper.updateMatchResultByGoal(matchGoals);
		return check;
	}
	
	@Override
	public int modifyMatchResultByOwnGoal(MatchOwnGoals matchOwnGoals)
	{
		int check = matchMapper.updateMatchResultByOwnGoal(matchOwnGoals);
		return check;
	}
	
	@Override
	public int modifyMatchKeeper(MatchGoalKeeper matchGoalKeeper)
	{
		int check = matchMapper.updateMatchKeeper(matchGoalKeeper);
		return check;
	}
	
	@Override
	public int modifyMatchKeeperT(MatchGoalKeeper matchGoalKeeper)
	{
		int check = matchMapper.updateMatchKeeperT(matchGoalKeeper);
		return check;
	}
	
	@Override
	public List<InGamePosition> getMainAndKeeper(MatchNoTeamName matchNoTeamName)
	{
		List<InGamePosition> list = matchMapper.selectMainAndKeeper(matchNoTeamName);
		System.out.println("service - getInGamePosition : "+list);
		return list;
	}
	
	@Override
	public List<PlayerInfo> getPlayerListByTeamName(String teamName) 
	{
		List<PlayerInfo> list = matchMapper.selectPlayerListByTeamName(teamName);
		return list;
	}
	
	@Override
	public List<InGamePosition> getCommutablePlayer(MatchNoTeamName matchNoTeamName)
	{
		List<InGamePosition> list = matchMapper.selectCommutablePlayer(matchNoTeamName);
		System.out.println("service - getInGamePosition : "+list);
		return list;
	}
	
	@Override
	public int removeMatchPlayer(MatchPlayer matchPlayer)
	{
		int check = matchMapper.deleteMatchPlayer(matchPlayer);
		return check;
	}
	
	@Override
	public InGamePosition getMatchKeeperT(MatchNoTeamName matchNoTeamName)
	{
		InGamePosition list = matchMapper.selectMatchKeeperT(matchNoTeamName);
		System.out.println("service - getInGamePosition : "+list);
		return list;
	}
	
	@Override
	public InGamePosition getLatelyEndTimeOfKeeper(MatchNoTeamName matchNoTeamName)
	{
		InGamePosition check = matchMapper.selectLatelyEndTimeOfKeeper(matchNoTeamName);
		return check;
	}
	
	@Override
	public MatchResult getMatchScore(int matchNo) {
		System.out.println(matchNo);
		MatchResult matchResult = matchMapper.selectMatchScore(matchNo);
		System.out.println(matchResult);
		return matchResult;
	}
	
	@Override
	public int modifyKeeperF(int matchNo) {
		System.out.println(matchNo);
		int row = matchMapper.updateKeeperF(matchNo);
		System.out.println(row);
		return row;
	}
	
	@Override
	public int modifyMatchScheduleF(int matchNo) {
		System.out.println(matchNo);
		int row = matchMapper.updateMatchF(matchNo);
		System.out.println(row);
		return row;
	}
	
	@Override
	public int modifyPlayerF(int matchNo) {
		System.out.println(matchNo);
		int row = matchMapper.updatePlayerF(matchNo);
		System.out.println(row);
		return row;
	}
	
	@Override
	public int modifyMatchResult(MatchResult matchResult) {
		System.out.println(matchResult);
		int row = matchMapper.updateMatchResult(matchResult);
		System.out.println(row);
		return row;
	}
	
	@Override
	public List<MatchResult> getFinishedMatch(){
		List<MatchResult> list = matchMapper.selectFinishedMatch();
		return list;
	}
	
	public List<MatchSchedule> getMatchScheduleT(){
		List<MatchSchedule> list = matchMapper.selectMatchScheduleT();
		return list;
	}
}











