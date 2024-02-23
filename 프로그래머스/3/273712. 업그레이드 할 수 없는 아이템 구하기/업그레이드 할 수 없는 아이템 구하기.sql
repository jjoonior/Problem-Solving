-- 코드를 작성해주세요
select a.item_id, item_name, rarity
from item_info a
join item_tree b on a.item_id = b.item_id 
where a.item_id not in (select parent_item_id from item_tree
                 where parent_item_id is not null)
order by a.item_id desc