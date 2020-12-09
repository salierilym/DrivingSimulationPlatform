import request from '@/utils/request'

// 查询实验环境列表
export function listEnvironment(query) {
  return request({
    url: '/information/environment/list',
    method: 'get',
    params: query
  })
}

// 查询实验环境详细
export function getEnvironment(id) {
  return request({
    url: '/information/environment/' + id,
    method: 'get'
  })
}

// 新增实验环境
export function addEnvironment(data) {
  return request({
    url: '/information/environment',
    method: 'post',
    data: data
  })
}

// 修改实验环境
export function updateEnvironment(data) {
  return request({
    url: '/information/environment',
    method: 'put',
    data: data
  })
}

// 删除实验环境
export function delEnvironment(id) {
  return request({
    url: '/information/environment/' + id,
    method: 'delete'
  })
}

// 导出实验环境
export function exportEnvironment(query) {
  return request({
    url: '/information/environment/export',
    method: 'get',
    params: query
  })
}